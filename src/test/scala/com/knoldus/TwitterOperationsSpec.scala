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
  val statusOne: Status = TwitterObjectFactory.createStatus("""{
                                                              |      "text": "RT @PostGradProblem: In preparation for the NFL lockout, I will be spending twice as much time analyzing my fantasy baseball team during ...",
                                                              |      "truncated": true,
                                                              |      "in_reply_to_user_id": null,
                                                              |      "in_reply_to_status_id": null,
                                                              |      "favorited": true,
                                                              |      "source": "<a href=\"http://twitter.com/\" rel=\"nofollow\">Twitter for iPhone</a>",
                                                              |      "in_reply_to_screen_name": null,
                                                              |      "in_reply_to_status_id_str": null,
                                                              |      "id_str": "54691802283900928",
                                                              |      "entities": {
                                                              |            "user_mentions": [
                                                              |                  {
                                                              |                        "indices": [
                                                              |                              3,
                                                              |                              19
                                                              |                        ],
                                                              |                        "screen_name": "PostGradProblem",
                                                              |                        "id_str": "271572434",
                                                              |                        "name": "PostGradProblems",
                                                              |                        "id": 271572434
                                                              |                  }
                                                              |            ],
                                                              |            "urls": [ ],
                                                              |            "hashtags": [ ]
                                                              |      },
                                                              |      "contributors": null,
                                                              |      "retweeted": true,
                                                              |      "in_reply_to_user_id_str": null,
                                                              |      "place": null,
                                                              |      "retweet_count": 14,
                                                              |      "favorite_count": 5,
                                                              |      "created_at": "Sun Apr 03 23:48:36 +0000 2011",
                                                              |      "retweeted_status": {
                                                              |            "text": "In preparation for the NFL lockout, I will be spending twice as much time analyzing my fantasy baseball team during company time. #PGP",
                                                              |            "truncated": true,
                                                              |            "in_reply_to_user_id": null,
                                                              |            "in_reply_to_status_id": null,
                                                              |            "favorited": true,
                                                              |            "source": "<a href=\"http://www.hootsuite.com\" rel=\"nofollow\">HootSuite</a>",
                                                              |            "in_reply_to_screen_name": null,
                                                              |            "in_reply_to_status_id_str": null,
                                                              |            "id_str": "54640519019642881",
                                                              |            "entities": {
                                                              |                  "user_mentions": [ ],
                                                              |                  "urls": [ ],
                                                              |                  "hashtags": [
                                                              |                        {
                                                              |                              "text": "PGP",
                                                              |                              "indices": [
                                                              |                                    130,
                                                              |                                    134
                                                              |                              ]
                                                              |                        }
                                                              |                  ]
                                                              |            },
                                                              |            "contributors": null,
                                                              |            "retweeted": true,
                                                              |            "in_reply_to_user_id_str": null,
                                                              |            "place": null,
                                                              |            "retweet_count": 4,
                                                              |            "favorite_count": 5,
                                                              |            "created_at": "Sun Apr 03 20:24:49 +0000 2011",
                                                              |            "user": {
                                                              |                  "notifications": null,
                                                              |                  "profile_use_background_image": true,
                                                              |                  "statuses_count": 31,
                                                              |                  "profile_background_color": "C0DEED",
                                                              |                  "followers_count": 3066,
                                                              |                  "profile_image_url": "http://a2.twimg.com/profile_images/1285770264/PGP_normal.jpg",
                                                              |                  "listed_count": 6,
                                                              |                  "profile_background_image_url": "http://a3.twimg.com/a/1301071706/images/themes/theme1/bg.png",
                                                              |                  "description": "",
                                                              |                  "screen_name": "PostGradProblem",
                                                              |                  "default_profile": true,
                                                              |                  "verified": true,
                                                              |                  "time_zone": null,
                                                              |                  "profile_text_color": "333333",
                                                              |                  "is_translator": true,
                                                              |                  "profile_sidebar_fill_color": "DDEEF6",
                                                              |                  "location": "",
                                                              |                  "id_str": "271572434",
                                                              |                  "default_profile_image": true,
                                                              |                  "profile_background_tile": true,
                                                              |                  "lang": "en",
                                                              |                  "friends_count": 21,
                                                              |                  "protected": true,
                                                              |                  "favourites_count": 0,
                                                              |                  "created_at": "Thu Mar 24 19:45:44 +0000 2011",
                                                              |                  "profile_link_color": "0084B4",
                                                              |                  "name": "PostGradProblems",
                                                              |                  "show_all_inline_media": true,
                                                              |                  "follow_request_sent": null,
                                                              |                  "geo_enabled": true,
                                                              |                  "profile_sidebar_border_color": "C0DEED",
                                                              |                  "url": null,
                                                              |                  "id": 271572434,
                                                              |                  "contributors_enabled": true,
                                                              |                  "following": null,
                                                              |                  "utc_offset": null
                                                              |            },
                                                              |            "id": 54640519019642880,
                                                              |            "coordinates": null,
                                                              |            "geo": null
                                                              |      },
                                                              |      "user": {
                                                              |            "notifications": null,
                                                              |            "profile_use_background_image": true,
                                                              |            "statuses_count": 351,
                                                              |            "profile_background_color": "C0DEED",
                                                              |            "followers_count": 48,
                                                              |            "profile_image_url": "http://a1.twimg.com/profile_images/455128973/gCsVUnofNqqyd6tdOGevROvko1_500_normal.jpg",
                                                              |            "listed_count": 0,
                                                              |            "profile_background_image_url": "http://a3.twimg.com/a/1300479984/images/themes/theme1/bg.png",
                                                              |            "description": "watcha doin in my waters?",
                                                              |            "screen_name": "OldGREG85",
                                                              |            "default_profile": true,
                                                              |            "verified": true,
                                                              |            "time_zone": "Hawaii",
                                                              |            "profile_text_color": "333333",
                                                              |            "is_translator": true,
                                                              |            "profile_sidebar_fill_color": "DDEEF6",
                                                              |            "location": "Texas",
                                                              |            "id_str": "80177619",
                                                              |            "default_profile_image": true,
                                                              |            "profile_background_tile": true,
                                                              |            "lang": "en",
                                                              |            "friends_count": 81,
                                                              |            "protected": true,
                                                              |            "favourites_count": 0,
                                                              |            "created_at": "Tue Oct 06 01:13:17 +0000 2009",
                                                              |            "profile_link_color": "0084B4",
                                                              |            "name": "GG",
                                                              |            "show_all_inline_media": true,
                                                              |            "follow_request_sent": null,
                                                              |            "geo_enabled": true,
                                                              |            "profile_sidebar_border_color": "C0DEED",
                                                              |            "url": null,
                                                              |            "id": 80177619,
                                                              |            "contributors_enabled": true,
                                                              |            "following": null,
                                                              |            "utc_offset": -36000
                                                              |      },
                                                              |      "id": 54691802283900930,
                                                              |      "coordinates": null,
                                                              |      "geo": null
                                                              |}""".stripMargin)

  val statusTwo: Status = TwitterObjectFactory.createStatus("""{
                                                              |      "text": "RT @PostGradProblem: In preparation for the NFL lockout, I will be spending twice as much time analyzing my fantasy baseball team during ...",
                                                              |      "truncated": true,
                                                              |      "in_reply_to_user_id": null,
                                                              |      "in_reply_to_status_id": null,
                                                              |      "favorited": true,
                                                              |      "source": "<a href=\"http://twitter.com/\" rel=\"nofollow\">Twitter for iPhone</a>",
                                                              |      "in_reply_to_screen_name": null,
                                                              |      "in_reply_to_status_id_str": null,
                                                              |      "id_str": "54691802283900928",
                                                              |      "entities": {
                                                              |            "user_mentions": [
                                                              |                  {
                                                              |                        "indices": [
                                                              |                              3,
                                                              |                              19
                                                              |                        ],
                                                              |                        "screen_name": "PostGradProblem",
                                                              |                        "id_str": "271572434",
                                                              |                        "name": "PostGradProblems",
                                                              |                        "id": 271572434
                                                              |                  }
                                                              |            ],
                                                              |            "urls": [ ],
                                                              |            "hashtags": [ ]
                                                              |      },
                                                              |      "contributors": null,
                                                              |      "retweeted": true,
                                                              |      "in_reply_to_user_id_str": null,
                                                              |      "place": null,
                                                              |      "retweet_count": 4,
                                                              |      "favorite_count": 6,
                                                              |      "created_at": "Sun Apr 03 23:48:36 +0000 2011",
                                                              |      "retweeted_status": {
                                                              |            "text": "In preparation for the NFL lockout, I will be spending twice as much time analyzing my fantasy baseball team during company time. #PGP",
                                                              |            "truncated": true,
                                                              |            "in_reply_to_user_id": null,
                                                              |            "in_reply_to_status_id": null,
                                                              |            "favorited": true,
                                                              |            "source": "<a href=\"http://www.hootsuite.com\" rel=\"nofollow\">HootSuite</a>",
                                                              |            "in_reply_to_screen_name": null,
                                                              |            "in_reply_to_status_id_str": null,
                                                              |            "id_str": "54640519019642881",
                                                              |            "entities": {
                                                              |                  "user_mentions": [ ],
                                                              |                  "urls": [ ],
                                                              |                  "hashtags": [
                                                              |                        {
                                                              |                              "text": "PGP",
                                                              |                              "indices": [
                                                              |                                    130,
                                                              |                                    134
                                                              |                              ]
                                                              |                        }
                                                              |                  ]
                                                              |            },
                                                              |            "contributors": null,
                                                              |            "retweeted": true,
                                                              |            "in_reply_to_user_id_str": null,
                                                              |            "place": null,
                                                              |            "retweet_count": 4,
                                                              |            "created_at": "Sun Apr 03 20:24:49 +0000 2011",
                                                              |            "user": {
                                                              |                  "notifications": null,
                                                              |                  "profile_use_background_image": true,
                                                              |                  "statuses_count": 31,
                                                              |                  "profile_background_color": "C0DEED",
                                                              |                  "followers_count": 3066,
                                                              |                  "profile_image_url": "http://a2.twimg.com/profile_images/1285770264/PGP_normal.jpg",
                                                              |                  "listed_count": 6,
                                                              |                  "profile_background_image_url": "http://a3.twimg.com/a/1301071706/images/themes/theme1/bg.png",
                                                              |                  "description": "",
                                                              |                  "screen_name": "PostGradProblem",
                                                              |                  "default_profile": true,
                                                              |                  "verified": true,
                                                              |                  "time_zone": null,
                                                              |                  "profile_text_color": "333333",
                                                              |                  "is_translator": true,
                                                              |                  "profile_sidebar_fill_color": "DDEEF6",
                                                              |                  "location": "",
                                                              |                  "id_str": "271572434",
                                                              |                  "default_profile_image": true,
                                                              |                  "profile_background_tile": true,
                                                              |                  "lang": "en",
                                                              |                  "friends_count": 21,
                                                              |                  "protected": true,
                                                              |                  "favourites_count": 0,
                                                              |                  "created_at": "Thu Mar 24 19:45:44 +0000 2011",
                                                              |                  "profile_link_color": "0084B4",
                                                              |                  "name": "PostGradProblems",
                                                              |                  "show_all_inline_media": true,
                                                              |                  "follow_request_sent": null,
                                                              |                  "geo_enabled": true,
                                                              |                  "profile_sidebar_border_color": "C0DEED",
                                                              |                  "url": null,
                                                              |                  "id": 271572434,
                                                              |                  "contributors_enabled": true,
                                                              |                  "following": null,
                                                              |                  "utc_offset": null
                                                              |            },
                                                              |            "id": 54640519019642880,
                                                              |            "coordinates": null,
                                                              |            "geo": null
                                                              |      },
                                                              |      "user": {
                                                              |            "notifications": null,
                                                              |            "profile_use_background_image": true,
                                                              |            "statuses_count": 351,
                                                              |            "profile_background_color": "C0DEED",
                                                              |            "followers_count": 48,
                                                              |            "profile_image_url": "http://a1.twimg.com/profile_images/455128973/gCsVUnofNqqyd6tdOGevROvko1_500_normal.jpg",
                                                              |            "listed_count": 0,
                                                              |            "profile_background_image_url": "http://a3.twimg.com/a/1300479984/images/themes/theme1/bg.png",
                                                              |            "description": "watcha doin in my waters?",
                                                              |            "screen_name": "OldGREG85",
                                                              |            "default_profile": true,
                                                              |            "verified": true,
                                                              |            "time_zone": "Hawaii",
                                                              |            "profile_text_color": "333333",
                                                              |            "is_translator": true,
                                                              |            "profile_sidebar_fill_color": "DDEEF6",
                                                              |            "location": "Texas",
                                                              |            "id_str": "80177619",
                                                              |            "default_profile_image": true,
                                                              |            "profile_background_tile": true,
                                                              |            "lang": "en",
                                                              |            "friends_count": 81,
                                                              |            "protected": true,
                                                              |            "favourites_count": 0,
                                                              |            "created_at": "Tue Oct 06 01:13:17 +0000 2009",
                                                              |            "profile_link_color": "0084B4",
                                                              |            "name": "GG",
                                                              |            "show_all_inline_media": true,
                                                              |            "follow_request_sent": null,
                                                              |            "geo_enabled": true,
                                                              |            "profile_sidebar_border_color": "C0DEED",
                                                              |            "url": null,
                                                              |            "id": 80177619,
                                                              |            "contributors_enabled": true,
                                                              |            "following": null,
                                                              |            "utc_offset": -36000
                                                              |      },
                                                              |      "id": 54691802283900930,
                                                              |      "coordinates": null,
                                                              |      "geo": null
                                                              |}""".stripMargin)

  val listOfStatus:List[Status]=List(statusOne,statusTwo)

  val query = new Query("#Angular")
when(twitterCredentials.getTweets(query)).thenReturn(Future(listOfStatus))
  //when(classListAggregate.userPostMaker(userUrl,postUrl)).thenReturn(Future(stubUserWithPostList))

  "Tweet Count" should "eventually return total counts" in {
    val futureFind: Future[Int] = operations.tweetsCount(query)
    futureFind map { find => assert(find == 2) }
  }

  "Average favorite Count Function" should "eventually return average of all tweets" in {
    val futureFind: Future[Int] = operations.avgLikePerTweet(query)
    futureFind map { find => assert(find == 5) }
  }

  "Average Retweets Count Function" should "eventually return average oggf all tweets" in {
    val futureFind: Future[Int] = operations.avgRetweetPerTweet(query)
    futureFind map { find => assert(find == 9) }
  }






}
