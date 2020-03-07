package com.knoldus.controller

import twitter4j.Query

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class TwitterOperations(twitterCredentials: TwitterCredentials) {
  /**
   * This function counts total number of tweets.
   *
   * @param hashTag It takes Hashtag as input tp fetch tweets.
   * @return It provides total number of tweets.
   */
  def tweetsCount(hashTag: Query): Future[Int] = {
    twitterCredentials.getTweets(hashTag).map(_.length)
  }

  /**
   * This function calculate average favorite counts.
   *
   * @param hashTag It takes Hashtag as input to fetch tweets.
   * @return It provides average favorite counts.
   */
  def avgLikePerTweet(hashTag: Query): Future[Int] = {
    val futureSumOfFev = twitterCredentials.getTweets(hashTag).map(_.foldLeft(0)((acc, ele) => acc + ele.getFavoriteCount))
    futureSumOfFev.map(sumOfFev => twitterCredentials.getTweets(hashTag).map(sumOfFev / _.length)).flatten


  }

  /**
   * This function average retweets count.
   *
   * @param hashTag It takes Hashtag as input to fetch tweets.
   * @return It provides average retweets counts.
   */
  def avgRetweetPerTweet(hashTag: Query): Future[Int] = {
    val futureSumOfRetweets = twitterCredentials.getTweets(hashTag).map(_.foldLeft(0)((acc, ele) => acc + ele.getRetweetCount))
    futureSumOfRetweets.map(sumOfRetweets => twitterCredentials.getTweets(hashTag).map(sumOfRetweets / _.length)).flatten
  }


}

