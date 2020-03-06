package com.knoldus.controller

import twitter4j.Query

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class TwitterOperations(twitterCredentials: TwitterCredentials) {

  def tweetsCount(hashTag: Query): Future[Int] = {
    twitterCredentials.getTweets(hashTag).map(_.length)
  }

  def avgLikePerTweet(hashTag: Query): Future[Int] = {
    val futureSumOfFev = twitterCredentials.getTweets(hashTag).map(_.foldLeft(0)((acc, ele) => acc + ele.getFavoriteCount))
    futureSumOfFev.map(sumOfFev => twitterCredentials.getTweets(hashTag).map(sumOfFev / _.length)).flatten


  }

  def avgRetweetPerTweet(hashTag: Query): Future[Int] = {
    val futureSumOfRetweets = twitterCredentials.getTweets(hashTag).map(_.foldLeft(0)((acc, ele) => acc + ele.getRetweetCount))
    futureSumOfRetweets.map(sumOfRetweets => twitterCredentials.getTweets(hashTag).map(sumOfRetweets / _.length)).flatten
  }


}
