package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class SendEmail implements JavaDelegate {
	private MailSender yahooMailSender;
	private SimpleMailMessage sendMailFromYahoo;
	
	public void setYahooMailSender(MailSender yahooMailSender) {
        this.yahooMailSender = yahooMailSender;
    }
	
	public void setSendMailFromYahoo(SimpleMailMessage sendMailFromYahoo) {
        this.sendMailFromYahoo = sendMailFromYahoo;
    }
	
	public void execute(DelegateExecution execution) throws Exception {
		 System.out.println("Spring Email Bean invoked");
		 String jobID = (String) execution.getVariable("jobID");
		 sendMailFromYahoo.setSubject("Work is allocated.JOB ID is" + jobID);
		 sendMailFromYahoo.setText("Start working on " +jobID);
		 yahooMailSender.send(sendMailFromYahoo);
	}

}

