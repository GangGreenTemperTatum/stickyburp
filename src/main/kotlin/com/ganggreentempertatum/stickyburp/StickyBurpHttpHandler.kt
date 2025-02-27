package com.ganggreentempertatum.stickyburp

import burp.api.montoya.http.handler.*
import burp.api.montoya.http.message.requests.HttpRequest
import burp.api.montoya.core.ToolType

class StickyBurpHttpHandler(private val tab: StickyBurpTab) : HttpHandler {
    override fun handleHttpRequestToBeSent(requestToBeSent: HttpRequestToBeSent): RequestToBeSentAction {
        val toolType = requestToBeSent.toolSource().toolType()
        var modifiedRequest = requestToBeSent.toString()

        for (variable in tab.getVariables()) {
            modifiedRequest = modifiedRequest.replace("\${${variable.name}}", variable.value)
        }

        return if (modifiedRequest != requestToBeSent.toString()) {
            RequestToBeSentAction.continueWith(
                HttpRequest.httpRequest(
                    requestToBeSent.httpService(),
                    modifiedRequest
                )
            )
        } else {
            RequestToBeSentAction.continueWith(requestToBeSent)
        }
    }

    override fun handleHttpResponseReceived(responseReceived: HttpResponseReceived): ResponseReceivedAction {
        return ResponseReceivedAction.continueWith(responseReceived)
    }
}
