package com.pmease.gitplex.web.page.repository.info.pullrequest.activity;

import java.util.Date;

import org.apache.wicket.markup.html.panel.Panel;

import com.pmease.gitplex.core.model.CloseInfo;
import com.pmease.gitplex.core.model.PullRequest;
import com.pmease.gitplex.core.model.User;

public class ClosePullRequest implements PullRequestActivity {

	private final PullRequest request;
	
	public ClosePullRequest(PullRequest request) {
		this.request = request;
	}
	
	@Override
	public Panel render(String panelId) {
		return new CloseActivityPanel(panelId, new PullRequestModel(request.getId()));
	}

	@Override
	public Date getDate() {
		return request.getCloseInfo().getCloseDate();
	}

	@Override
	public User getUser() {
		return request.getCloseInfo().getClosedBy();
	}

	@Override
	public String getAction() {
		if (request.getCloseInfo().getCloseStatus() == CloseInfo.Status.INTEGRATED)
			return "Integrated";
		else
			return "Discarded";
	}

}
