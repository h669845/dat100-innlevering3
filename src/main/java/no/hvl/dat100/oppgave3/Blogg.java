package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;

	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) != -1);
	}

	public boolean ledigPlass() {
		return (nesteledig < innleggtabell.length);
	}

	public boolean leggTil(Innlegg innlegg) {

		if (ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
	     String tekst = nesteledig + "\n";
        for (int i = 0; i < nesteledig; i++) {
            tekst += innleggtabell[i].toString();
            
        }
        return tekst;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteledig; i++) {
			nyTabell[i] = innleggtabell[i];
		}
		innleggtabell = nyTabell;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!ledigPlass()) {
			utvid();
		}
		return leggTil(innlegg);

	}

	public boolean slett(Innlegg innlegg) {

		int index = finnInnlegg(innlegg);
		if (index != -1) {
			nesteledig--;
			innleggtabell[index] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			return true;
		}
		return false;
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}