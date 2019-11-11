package art_vault;

class A {
	public void badger() {
		System.out.println("A");
	}
	public void cat() {
		badger();
	}
}

class B extends A {
	@Override
	public void badger() {
		System.out.println("B");
	}
}

public class ArtVaultApp {

	public static void main(String[] args) {
		B b = new B();
		b.cat();

	}

}
