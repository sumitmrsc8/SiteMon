package sitemonitoringagain.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.io.Serializable;
import java.util.*;

import sitemonitoringagain.entity.*;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sitemonitoringagain.service.CheckService;
import sitemonitoringagain.service.HelloSpringService;

@Getter
@Setter
@ManagedBean()
@ViewScoped
public class CheckListController implements Serializable {
	
/*	@ManagedProperty("#{helloSpringService}")
	private HelloSpringService helloSpringService;*/
	
	/*
	public String sayHello(){
			return helloSpringService.sayHello();
	}*/
	
	@ManagedProperty("#{checkService}")
	private CheckService checkService;
	
	private List<Check> checks;
	private Check check=new Check();	// Need to initialized the object
	
	@PostConstruct
	public void loadChecks(){
			checks=checkService.findAll();
	}
	
	public void save(){
			checkService.save(check);
			check=new Check();
			checks=checkService.findAll();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Checked Saved!!!",null));
	}
	
	public void remove(Check check){
		checkService.remove(check);
		checks=checkService.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Checked Removed!!!",null));
	}
	
	public void clear(){
		check=new Check();		
	}

}
