package algorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static algorithm.AgeDifference.SMALLEST;
import static algorithm.AgeDifference.BIGGEST;

public class PersonComparer {
	private final List<Person> persons;

	public PersonComparer(List<Person> persons) {
		this.persons = persons;
	}

	public AgeCompare findAgeDifference(AgeDifference ageDifference) {
		List<AgeCompare> ageComparisons = new ArrayList<>();
		Optional<AgeCompare> result = Optional.empty();

		persons.forEach(p1 -> {
			persons.stream()
					.filter(p2 -> !p1.equals(p2))
					.map(p2 -> p1.getBirthDate() < p2.getBirthDate()
							? new AgeCompare(p1, p2)
							: new AgeCompare(p2, p1))
					.forEach(ageComparisons::add);
		});

		if(ageDifference.equals(SMALLEST)) {
			result = ageComparisons.stream()
					.min(Comparator.comparingLong(AgeCompare::getAgeDifference));
		}

		if(ageDifference.equals(BIGGEST)) {
			result = ageComparisons.stream()
					.max(Comparator.comparingLong(AgeCompare::getAgeDifference));
		}

		return result.orElse(new AgeCompare());
	}
}


