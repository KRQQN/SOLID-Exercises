package algorithm;
import java.util.ArrayList;
import java.util.List;

public class PersonComparer {
	private final List<Person> persons;

	public PersonComparer(List<Person> person) {
		this.persons = person;
	}

	public AgeCompare Find(AgeDifference smallestOrBiggest) {
		
		List<AgeCompare> ageComparisons = new ArrayList<>();

		for (int i = 0; i < persons.size() - 1; i++) {
			for (int j = i + 1; j < persons.size(); j++) {

				AgeCompare ageComparison = new AgeCompare();

				if (persons.get(i).birthDate.getTime() < persons.get(j).birthDate.getTime()) {
					ageComparison.youngestPerson = persons.get(i);
					ageComparison.oldestPerson = persons.get(j);
				} else {
					ageComparison.youngestPerson = persons.get(j);
					ageComparison.oldestPerson = persons.get(i);
				}

				ageComparison.ageDifference = ageComparison.oldestPerson.birthDate.getTime() - ageComparison.youngestPerson.birthDate.getTime();
				ageComparisons.add(ageComparison);
			}
		}


		if (ageComparisons.isEmpty()) {
			return new AgeCompare();
		}

		//
		AgeCompare answer = ageComparisons.get(0);



		for (AgeCompare comparison : ageComparisons) {
            switch (smallestOrBiggest) {
                case SMALLEST -> {
                    if (comparison.ageDifference < answer.ageDifference) {
                        answer = comparison;
                    }
                }
                case BIGGEST -> {
                    if (comparison.ageDifference > answer.ageDifference) {
                        answer = comparison;
                    }
                }
            }
		}

		return answer;
	}
}
