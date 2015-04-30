package avis;

import java.util.Collection;


public class Avis extends Book {

	/** 
	 * @uml.property name="membre"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="avis:avis.Membre"
	 */
	private Membre membre = new avis.Membre();

	/** 
	 * Getter of the property <tt>membre</tt>
	 * @return  Returns the membre.
	 * @uml.property  name="membre"
	 */
	public Membre getMembre() {
		return membre;
	}

	/** 
	 * Setter of the property <tt>membre</tt>
	 * @param membre  The membre to set.
	 * @uml.property  name="membre"
	 */
	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	/**
	 * @uml.property  name="item"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="avis:avis.Item"
	 */
	private Item item = new avis.Item();

	/**
	 * Getter of the property <tt>item</tt>
	 * @return  Returns the item.
	 * @uml.property  name="item"
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Setter of the property <tt>item</tt>
	 * @param item  The item to set.
	 * @uml.property  name="item"
	 */
	public void setItem(Item item) {
		this.item = item;
	}

		
		/**
		 */
		public void DonnerAvis(){
		}

}
