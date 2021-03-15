package fr.carbonIT.demo.chasseAuTresors.game.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import fr.carbonIT.demo.chasseAuTresors.game.person.Adventurer;
import fr.carbonIT.demo.chasseAuTresors.game.person.Person;
import fr.carbonIT.demo.chasseAuTresors.game.person.PersonFactory;
import fr.carbonIT.demo.chasseAuTresors.game.type.Movement;
import fr.carbonIT.demo.chasseAuTresors.game.type.Orientation;

 class PersonFactoryTest {
	
	@Test
	 void getAdventurer() {
		String infoLine = "A - Indiana - 3 - 2 - E - AGA";
		Person person = PersonFactory.getPerson(infoLine);
		assertThat(person).isInstanceOf(Adventurer.class);
		assertThat(person.getName()).isEqualTo("Indiana");
		assertThat(person.getPosition().getRow()).isEqualByComparingTo(2);
		assertThat(person.getPosition().getColumn()).isEqualByComparingTo(3);
		assertThat(person.getOrientation()).isEqualTo(Orientation.EST);
		Adventurer adventurer = (Adventurer)person;
		Movement[] sequenceOfMovement = new Movement[] { Movement.A, Movement.G, Movement.A };
		assertThat(adventurer.getSequenceOfMouvement()).isEqualTo(sequenceOfMovement);
		
	}
	
}
