package com.emannuel.organizecafe.organizecafe.controller;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class TestAdd {
	public static final List<Collaborator> COLLABORATOR_LIST = new ArrayList<>() {{
		add(new Collaborator("93825792064", "Jackson"));
		add(new Collaborator("93835795064", "Junior"));
		add(new Collaborator("93855798064", "Siclano"));
		add(new Collaborator("93875798064", "CJ"));
		add(new Collaborator("93885798064", "Bob"));
	}};

	public static final Collaborator COLLABORATOR = COLLABORATOR_LIST.get(0);


}
