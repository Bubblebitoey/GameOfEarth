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
		addQuestion("Toilet Paper", "Thieves are stealing our toilet paper in public toilets. Install facial recognition cameras so that each visitor can only take two pieces of toilet paper.", -500, 0, 200, 14);
		addQuestion("Gluten Free Labeling", "Business are claiming their products are gluten-free when they are not. We should set clear standards for gluten-free labeling!", 0, 30, 0, -40);
		addQuestion("Ecofriendly Standards", "Companies are not meeting the eco-friendly standards. Let them continue for a small annual fine?", 300, 12, -300, -15);
		addQuestion("Indigenous Benefits", "We should compensate the indigenous inhabitants with extra social benefits so they can live in harmony.", 0, 8, 0, -9);
		addQuestion("Cure the Cows", "Our cows are infected with a deadly disease! stop beef product until the cows are cured?", -800, 20, 1000, -18);
		addQuestion("Install Toll Stations", "A hurricane has destroyed all the routes entering the country except for one. Let's install toll stations on the remaining route entering the country instead of repairing all of them.", 150, -10, -200, 20);
		addQuestion("Free Up Medical Funds", "Patients that are in vegetative state drains millions of our medical funds. Allow euthanasia and reduce such funds?", 200, 38, 200, -40);
		addQuestion("Recycled Diapers", "Our hospitals are filling up with sick infants that have been using unclean recycled diapers. Close down this unethical factory?", 520, 14, 380, -20);
		addQuestion("Keeping Oceans Blue", "With rising unkeep costs, the chemical waste treatment system is a burden. Allow factories to pour their waste into the ocean as long as they dye their waste blue!", 432, 12, 0, -15);
		addQuestion("Expand airport", "Our airport has reached maximum capacity. let's build a new runway?", 300, 28, 0, -20);
		addQuestion("Blackhole Disposal", "Let's create an artificial black hole to dispose of all our waste! It's going to be really really expensive, and vey very dangerous.", -600, -10, 500, 10);
		addQuestion("New security fee", "Tight security at airport is discouraging tourists. Allow wealthy tourists to bypass security for a small fee?", 422, 15, -582, -16);
		addQuestion("Energy Production Cap", "Our energy companies are extracting more natural resources than we need. Put a production cap on how much they can extract every year?", -80, 0, 0, 100);
		addQuestion("Tighten boarder security", "With increasing tourists, terrorists can easily slip into our country, we need jail any suspicious personal first before questioning!", -130, -2, 180, 1);
		addQuestion("Give Worker Raise", "The oil workers are planning a strike due to low pay. Increase their salary subsidies?", 100, 0, -100, 0);
		addQuestion("Illegal Hospital Waste", "A hospital was found discharging medical waste illegaly. Close down the hospital?", -102, -1, 201, 3);
		addQuestion("Print Money", "Our government loans are getting bigger every year. Cut a forest to print lots of money so we can pay off the debt?", 110, 0, -120, 0);
		addQuestion("Parenting License", "Parenting requires real knowledge. To act on rising child abandonment, we must make all parents pay for a license before having a child?", 0, -1, 0, 4);
		addQuestion("Post-Disaster", "Our airport was destroyed by the tornado. Repair the damaged airport?", 100, 2, 0, -4);
		addQuestion("Monsoon Season", "Weather guy predicts a monsoon to hit our annual sports event. Let's clear the clouds so we can attract more tourists for the celebration!", 240, 4, -200, -1);
		addQuestion("Free housing", "Rising property prices force our newly couples to live with their parents, build more free housing for our citizens?", 100, 3, -150, -5);
		addQuestion("Car Emissions Coverup", "A car company miscalculated their cars carbon emissions. Let's keep quite?..I mean its been there for years now and nobody noticed.", 123, 0, -140, 1);
		addQuestion("More street lamps", "The new 'Slapamon Go' game is causing people to ealk into ponds. Build more street lamps?", 290, 3, -300, -5);
		addQuestion("New Wind Farms", "The winds have changed. Our wind farms are becoming ineffective and we end up burning coal to meet demands. Build new wind farms?", -100, 0, 110, 0);
		addQuestion("Exercise For everyone", "Obesity related diseases are on the rise. Obesity doesn't run in the family, the problem is no one runs in the family. Mandatory exercise for everyone", 0, 1, 0, -2);
		addQuestion("Recycle trucks", "Citizens are only recycling on the one day of the week that recycle truck comes. Have them come every day instead?", -120, 3, 200, -2);
		addQuestion("Use Dying Reef", "Land prices are so high, citizens are migrating overseas. Reclaim land over the coral reef and sell the land to developers?", 100, 1, 90, -1);
		addQuestion("Find the lazy", "We should put trackers on everyone in the country to see if anyone is being lazy.. To enhance productivity, of course.", 350, -1, -400, 0);
		addQuestion("Remove Air Pollutants", "With new city construction, mass amounts of pollutants are floating in the air. All buildings should have an air scrubber to help remove these pollutants.", -100, 1, 130, -2);
		addQuestion("Cheap Public Transport", "There are always traffic jams during peaks hours. Let's smooth out the traffic with cheap public transport.", -110, 0, 120, 0);
		addQuestion("Cryo-Freeze the Sick", "Allow unprecedented court ruling to cryo-freeze the little girl until the day we can cure her cancer?", 100, 3, -120, -3);
		addQuestion("Coverup Deforestation", "A state-owned logging company has been caught with illegal deforestation, let's cover this up by releasing fake reports.", 100, 0, -100, 0);
		addQuestion("Drug Addiction Hotline", "Rising number of students are turning to drugs for stress relief. Setup hotlines to help students with their problems?", 0, 1, 0, -2);
		addQuestion("Local Farmers", "Imported vegetables are expensive. Subsidize local farmers for producing cheap local veggies?", -220, 0, 250, 0);
		addQuestion("Remove Speed Bumps", "Constant speeding up and slowing down gives off more emissions. Remove all speed bumps?", -230, -1, 230, 2);
		addQuestion("Free money", "Financial problems are the top reason for divorce. Give out free money to couples to keep them together?", 300, 3, -200, 0);
		addQuestion("Child labor", "Child labor laws creating homeless starving children. Check the factory environment and allow the children to work for a warm meal?", 300, 2, -200, 0);
		addQuestion("Under 21 sales Tax", "Spoiled kids are overspending their parents fortune. Add a sale tax for spenders under 21?", -100, -1, 200, 2);
		addQuestion("More Recycle Bins", "It is hard to recycle when there are no recycling bins. Increase the number of recycling bins?", -152, 0, 170, 0);
		addQuestion("Plastic bottle Refunds", "A lot of the nondegradable plastic is ending up in our landfills. Install refund machines so that every 20,000 plastic bottles collected could return a plane ticket.", -100, 1, 120, -1);
		addQuestion("Breastfeeding", "Breastfeeding is beneficial to both the baby and mother. Sadly new mothers resort to milk powder for convenient. Subsidize breast feeding?", -100, 2, 0, -1);
		addQuestion("Prevent illegal Mining", "Citizens have been illegally digging up coal in their backyards. Deport them from their home to prevent this?", -100, -1, 120, 1);
		addQuestion("Tobocco Secret", "Tobacco companies are secretly hiring teenager to get other teenager to smoke. Prosecute the tobocco companies?", -100, 3, 180, -3);
		addQuestion("Regulate Soda Ads", "Soda companies discovered they can legally advertise through movie scenes. Fix this loophole to prevent them from advertising to children", 0, 1, 60, -2);
		addQuestion("Napkin Recycling", "A tissue manufacturing company wants to expand their operations by bleaching dirty napkins. Close down this company?", 100, 2, 120, 0);
		addQuestion("Hire Overseas Nurses", "There is a shortage of nurses. Fund a programme to hire overseas nurses to come help?", 200, 1, 0, -2);
		addQuestion("Sell Untested Drug", "A pharmaceutical company wants to give us a donation so their new drug can bypass testing. Allow the medicine to be sold without testing?", 0, -2, 0, 1);
		addQuestion("Runway Extension", "A lot of fuel wasted when a plane lands. Let's invest in a runway extension so planes use less fuel when landing.", -120, 0, -150, 0);
		addQuestion("Veggie Mondays", "All meat no veggies is not good for your health. Enforce Veggie Mondays on all citizen?", -100, 1, -20, 0);
	}
}
