package com.knoldus

import com.knoldus.controller.{TwitterCredentials, TwitterOperations}
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{AsyncFlatSpec, BeforeAndAfterAll}
import twitter4j.{Query, Status, TwitterObjectFactory}

import scala.concurrent.Future

class TwitterOperationsSpec extends AsyncFlatSpec with BeforeAndAfterAll with MockitoSugar {

  val twitterCredentials: TwitterCredentials = mock[TwitterCredentials]
  val operations:TwitterOperations=new TwitterOperations(twitterCredentials)
  val statusOne: Status = TwitterObjectFactory.createStatus("Tweet 1 #ElonMusk")
  val statusTwo: Status = TwitterObjectFactory.createStatus("Tweet 2 #ElonMusk")
  val listOfStatus:List[Status]=List(statusOne,statusTwo)

  val query = new Query("#ElonMusk")
when(twitterCredentials.getTweets(query)).thenReturn(Future(listOfStatus))
  //when(classListAggregate.userPostMaker(userUrl,postUrl)).thenReturn(Future(stubUserWithPostList))

  "Tweet Count" should "eventually return total counts" in {
    val futureFind: Future[Int] = operations.tweetsCount(query)
    futureFind map { find => assert(find == 2) }
  }






}
