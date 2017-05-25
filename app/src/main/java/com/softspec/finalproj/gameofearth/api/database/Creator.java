package com.softspec.finalproj.gameofearth.api.database;

import com.softspec.finalproj.gameofearth.model.database.Database;
import com.softspec.finalproj.gameofearth.model.question.Question;
import com.softspec.finalproj.gameofearth.model.question.QuestionCreator;
import com.softspec.finalproj.gameofearth.model.resource.AcceptCreator;
import com.softspec.finalproj.gameofearth.model.resource.DenyCreator;
import com.softspec.finalproj.gameofearth.model.resource.Resource;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Fri 26/May/2017 - 2:11 AM
 */
public class Creator {
	private Map<Class<? extends com.softspec.finalproj.gameofearth.model.creator.Creator>, com.softspec.finalproj.gameofearth.model.creator.Creator> creators;
	private List<Resource> aResources = new ArrayList<>();
	private List<Resource> dResources = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();
	
	public Creator(Database database) {
		creators = new HashMap<>();
		creators.put(QuestionCreator.class, new QuestionCreator().setDatabase(database));
		creators.put(AcceptCreator.class, new AcceptCreator().setDatabase(database));
		creators.put(DenyCreator.class, new DenyCreator().setDatabase(database));
		
		makeList();
	}
	
	private void addQuestion(String name, String description, long aCO2, long aPOP, long dCO2, long dPOP) {
		Resource accept = new Resource.Builder(Question.getStatic_id()).setCo2(aCO2).setPop(aPOP).build();
		Resource deny = new Resource.Builder(Question.getStatic_id()).setCo2(dCO2).setPop(dPOP).build();
		
		Question q = new Question(name, description);
		
		questions.add(q);
		aResources.add(accept);
		dResources.add(deny);
	}
	
	public synchronized void insert() {
		creators.get(QuestionCreator.class).setList(questions).insert();
		creators.get(AcceptCreator.class).setList(aResources).insert();
		creators.get(DenyCreator.class).setList(dResources).insert();
	}
	
	private void makeList() {
		addQuestion("Toilet Paper", "Thieves are stealing our toilet paper in public toilets. Install facial recognition cameras so that each visitor can only take two pieces of toilet paper.", -150, 0, 100, 2);
		addQuestion("Gluten Free Labeling", "Business are claiming their products are gluten-free when they are not. We should set clear standards for gluten-free labeling!", 0, 3, 0, -5);
		addQuestion("Ecofriendly Standards", "Companies are not meeting the eco-friendly standards. Let them continue for a small annual fine?", 100, 2, -120, -1);
		addQuestion("Indigenous Benefits", "We should compensate the indigenous inhabitants with extra social benefits so they can live in harmony.", 0, 3, 0, -5);
		addQuestion("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?", -100, 3, 150, -2);
		addQuestion("Install Toll Stations", "A hurricane has destroyed all the routes entering the country except for one. Let's install toll stations on the remaining route entering the country instead of repairing all of them.", 30, -1, -20, 2);
		addQuestion("Free Up Medical Funds", "Patients that are in vegetative state drains millions of our medical funds. Allow euthanasia and reduce such funds?", 12, 12, 12, 12);
		addQuestion("Recycled Diapers", "Our hospitals are filling up with sick infants that have been using unclean recycled diapers. Close down this unethical factory?", 240, 2, 120, -7);
		addQuestion("Keeping Oceans Blue", "With rising unkeep costs, the chemical waste treatment system is a burden. Allow factories to pour their waste into the ocean as long as they dye their waste blue!", 200, 4, 0, -2);
		addQuestion("Expand airport", "Our airport has reached maimum capacity. let's build a new runway?", 300, 8, 0, -3);
		addQuestion("Blackhole Disposal", "Let's create an artificial black hole to dispose of all our waste! It's going to be really really expensive, and vey very dangerous.", -100, -1, 90, 1);
		addQuestion("New security fee", "Tight security at airport is discouraging tourists. Allow wealthy tourists to bypass security for a small fee?", 212, 1, -250, -2);
		addQuestion("Energy Production Cap", "Our energy companies are extracting more natural resources than we need. Put a production cap on how much they can extract every year?", -80, 0, 0, 100);
		addQuestion("Tighten boarder security", "With increasing tourists, terrorists can easily slip into our country, we need jail any suspicious personal first before questioning!", -130, -2, 180, 1);
		addQuestion("Give Worker Raise", "The oil workers are planning a strike due to low pay. Increase their salary subsidies?", 100, 0, -100, 0);
		addQuestion("Illegal Hospital Waste", "A hospital was found discharging medical waste illegaly. Close down the hospital?", -102, -1, 201, 3);
		addQuestion("Print Money", "Our government loans are getting bigger every year. Cut a forest to print lots of money so we can pay off the debt?", 110, 0, -120, 0);
		addQuestion("Parenting License", "parenting requires real knowledge. To act on rising child abandonment, we must make all parents pay for a license before having a child?", 0, -1, 0, 4);
		addQuestion("Post-Disaster", "Our airport was destroyed by the tornado. Repair the damaged airport?", 100, 2, 0, -4);
		addQuestion("Monsoon Season", "Weather guy predicts a monsoon to hit our annual sports event. Let's clear the clouds so we can attract more tourists for the celebration!", 240, 4, -200, -1);
		addQuestion("Free housing", "Rising property prices force our newly couples to live with their parents, build more free housing for our citizens?", 100, 3, -150, -5);
		addQuestion("Car Emissions Coverup", "A car company miscalculated their cars carbon emissions. Let's keep quite?..I mean its been there for years now and nobody noticed.", 123, 0, -140, 1);
		addQuestion("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?", 12, 12, 12, 12);
		addQuestion("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?", 12, 12, 12, 12);
		addQuestion("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?", 12, 12, 12, 12);
		addQuestion("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?", 12, 12, 12, 12);
		addQuestion("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?", 12, 12, 12, 12);
		
		
		
		
		
		
		
	}
}
