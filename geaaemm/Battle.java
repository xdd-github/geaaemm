public class Battle {
	private String name;
	private boolean alive;
	private double health, phAtk, spAtk, phDef, spDef;
	private double xHealth, xPhAtk, xSpAtk, xPhDef, xSpDef; // Prozentualer Perma-Bonus (EINES Charakters) fürs
															// Abschließen vom Spiel
	private int exp, level, highestLevelReached;

	public Battle(String name) {
		this.name = name;
		this.alive = true;
		this.health = getStats("health");
		this.phAtk = getStats("atk");
		this.spAtk = getStats("atk");
		this.phDef = getStats("def");
		this.spDef = getStats("def");
		this.exp = 0;
	}

	public double getStats(String h) {
		double stat;
		switch (h) {
		case "health":
			stat = Math.random() * 20 + 70;
			stat = roundTo2Digets(stat);
			break;
		case "atk":
			stat = Math.random() * 20 + 30;
			stat = roundTo2Digets(stat);
			break;
		case "def":
			stat = (Math.random() * 20 + 20);
			stat = roundTo2Digets(stat);
			break;
		default:
			stat = 0;
		}
		return stat;

	}

	public double roundTo2Digets(double i) {
		i *= 100;
		i = Math.round(i);
		return i /= 100;
	}

	public Battle(String name, boolean alive, double health, double phAtk, double spAtk, double phDef, double spDef,
			int exp) {
		this.name = name;
		this.alive = alive;
		this.health = health;
		this.phAtk = phAtk;
		this.spAtk = spAtk;
		this.phDef = phDef;
		this.spDef = spDef;
		this.exp = exp;
	}

	public void showStats() {
		System.out.println("Your Stats: " + name + "\nHealth: " + this.health + "\nphysical Attack: " + this.phAtk
				+ "\nspecial Attack: " + this.spAtk + "\nphysical Defense: " + this.phDef + "\nspecial Defense: "
				+ this.spDef + "\nExperience: " + this.exp);
	}

	public void useSpecialAttack(double spellDamage, double enemySpDef, double enemyHealth) {
		double dmg = spellDamage * this.spAtk;
		dmg = dmg * 100 / enemySpDef;
		enemyHealth -= dmg;
	}
}
