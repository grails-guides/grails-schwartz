package demo

import groovy.transform.CompileStatic

@CompileStatic
class EmailService {

    void send(String user) {
        println "Sending email to ${user}"
    }
}
