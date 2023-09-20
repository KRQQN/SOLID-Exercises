package algorithm;
public class AgeCompare {
	public Person youngestPerson;
	public Person oldestPerson;
	public long ageDifference;

	public AgeCompare() {}

	public AgeCompare(Person youngest, Person oldest) {
		this.youngestPerson = youngest;
		this.oldestPerson = oldest;
		this.ageDifference = Math.abs(youngest.getBirthDate() - oldestPerson.getBirthDate());
	}

	public long getAgeDifference() {
		return ageDifference;
	}
}
