package com.example.chat

import org.scalatra.test.specs2._

class ChatControllerSpec extends ScalatraSpec { def is =
  "GET /pages/:slug on ChatController"          ^
    "should return status 200"                  ! pagesWork^
    "shows the word 'Bacon' in the body"        ! containsBacon^
                                                end

  addServlet(classOf[ChatController], "/*")

  def pagesWork = get("/pages/bacon-ipsum") {
    status must_== 200
  }

  def containsBacon = get("/pages/bacon-ipsum") {
    body must contain("Bacon")
  }
}