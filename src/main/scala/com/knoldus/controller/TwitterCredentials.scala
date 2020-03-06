package com.knoldus.controller

import twitter4j.auth.AccessToken
import twitter4j.{Query, Status, TwitterFactory}

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions

class TwitterCredentials {
  def getTweets(hashtag: Query): Future[List[Status]] = {
    val twitter = new TwitterFactory().getInstance()
    // Authorising with your Twitter Application credentials
    twitter.setOAuthConsumer("e6uS4phTxImI68qlA6h4V3zwR",
      "M8b4Q3sudgU9mNZgJx1onUlqQYi5h5YCK1GVacjAc8yHDAohFc")
    twitter.setOAuthAccessToken(new AccessToken(
      "160922224-AKOoOasbqi3huqT7uyq4Og0Oqlucn8rKeD9IcUvU",
      "7HgIJUmjOX2AZThvVp7RPWsZwOrW1ffpvkEpjeBSQynnH"))
    Future(twitter.search(hashtag).getTweets.asScala.toList)
  }
}
