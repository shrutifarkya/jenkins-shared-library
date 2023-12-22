// my-jenkins-library/vars/sendFailureEmail.groovy
def call() {
    // Load the JavaMail library using Jenkins built-in class loader
    def mailLib = Jenkins.instance.pluginManager.uberClassLoader.loadClass("com.sun.mail.util.MailLogger")

    // Use the loaded class to send the email
    emailext body: "Pipeline failed: ${env.PIPELINE_NAME} - Build #${currentBuild.number}",
            subject: "FAILURE: ${env.PIPELINE_NAME} - Build #${currentBuild.number}",
            to: "${EMAIL_ADDRESS}",
            mimeType: 'text/html',
            replyTo: "${EMAIL_ADDRESS}",
            from: "${EMAIL_ADDRESS}",
            smtpServer: "${SMTP_SERVER}",
            smtpPort: "${SMTP_PORT}",
            attachLog: true,
            cc: '',
            bcc: '',
            charset: 'UTF-8'
}
