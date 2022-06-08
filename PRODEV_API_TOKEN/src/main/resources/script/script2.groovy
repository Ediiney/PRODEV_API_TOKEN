
import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import groovy.json.*;
def Message processData(Message message) {
    //Body
    def body = message.getBody(String);
    def jsonParser = new JsonSlurper()
    def jsonObject = jsonParser.parseText(body)
        
    def json = JsonOutput.toJson(
        acess_token : jsonObject.data.access_token
        )
        // println json
        message.setBody(JsonOutput.prettyPrint(json))
    message.setHeader("Content-Type", "application/json")
   
    return message;
}