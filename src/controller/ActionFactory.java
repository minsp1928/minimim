package controller;

import actionController.LoginAction;
import actionController.MainAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("index")) {//index를 타고 main으로 넘어가기
			action = new MainAction();
		}else if(command.equals("login")) {//index를 타고 main으로 넘어가기
			action = new LoginAction();
		}
		return action;
	}
}
