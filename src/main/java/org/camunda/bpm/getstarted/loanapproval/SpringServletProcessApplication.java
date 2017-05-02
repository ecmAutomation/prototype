package org.camunda.bpm.getstarted.loanapproval;


import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.PreUndeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.ProcessEngine;

@ProcessApplication("Loan Approval App")
public class SpringServletProcessApplication extends ServletProcessApplication  {

  @PostDeploy
  public void startProcess(ProcessEngine processEngine) {
    System.out.println("Invoking @PostDeploy annotation in " + getClass().getName());
    System.out.println("Starting loanApproval processdefinition");
   
    processEngine.getRuntimeService().startProcessInstanceByKey("loanApproval");
    //System.out.println("Starting testResolveBeanFromJobExecutor processdefinition");
    //processEngine.getRuntimeService().startProcessInstanceByKey("testResolveBeanFromJobExecutor");
  }

  @PreUndeploy
  public void remove() {
    System.out.println("Invoking @PreUndeploy annotation in " + getClass().getName());
    System.out.println("Undeploying SpringServletProcessApplication-Example");
  }

}

/*
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Starter implements InitializingBean {

  @Autowired
  private RuntimeService runtimeService;

  public void afterPropertiesSet() throws Exception {
    runtimeService.startProcessInstanceByKey("loanApproval");
  }

  public void setRuntimeService(RuntimeService runtimeService) {
    this.runtimeService = runtimeService;
  }

}*/

