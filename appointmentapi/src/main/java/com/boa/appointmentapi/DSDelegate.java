package com.boa.appointmentapi;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component("dsDelegate")
@Slf4j
public class DSDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		 log.info("\n\n  ... LoggerDelegate invoked by "
		            + "activtyName='" + execution.getCurrentActivityName() + "'"
		            + ", activtyId=" + execution.getCurrentActivityId()
		            + ", processDefinitionId=" + execution.getProcessDefinitionId()
		            + ", processInstanceId=" + execution.getProcessInstanceId()
		            + ", businessKey=" + execution.getProcessBusinessKey()
		            + ", executionId=" + execution.getId()
		            + ", variables=" + execution.getVariables()
		            + " \n\n");
	}

}
