public class Applicatie
{

	private PERTNetwerk<Vak, Integer> netwerk = new PERTNetwerk<Vak, Integer>();

	public Applicatie()
	{
		createExampleData();
		netwerk.createTopologicalList();
		netwerk.getStartTime();
		netwerk.getLastStartTime();

		// Print topolist for results:
		for (Vak vak : netwerk.getTopoList())
		{
			System.out.println(vak.getNaam() + " " + vak.getMinPathValue()
				+ " " + vak.getMaxPathValue());
		}
	}

	/**
	 * Creates testing data
	 */
	public void createExampleData()
	{
		// Create vertices
		Vak vak1 = new Vak("A");
		Vak vak2 = new Vak("B");
		Vak vak3 = new Vak("C");
		Vak vak4 = new Vak("D");
		Vak vak5 = new Vak("E");
		Vak vak6 = new Vak("F");
		Vak vak7 = new Vak("G");
		Vak vak8 = new Vak("H");

		// Put vertices
		netwerk.putVertex(vak1);
		netwerk.putVertex(vak2);
		netwerk.putVertex(vak3);
		netwerk.putVertex(vak4);
		netwerk.putVertex(vak5);
		netwerk.putVertex(vak6);
		netwerk.putVertex(vak7);
		netwerk.putVertex(vak8);

		// Put edges
		netwerk.putEdge(vak1, vak2, 3);
		netwerk.putEdge(vak1, vak4, 1);
		netwerk.putEdge(vak1, vak7, 3);
		netwerk.putEdge(vak2, vak6, 1);
		netwerk.putEdge(vak2, vak3, 1);
		netwerk.putEdge(vak4, vak5, 1);
		netwerk.putEdge(vak5, vak6, 1);
		netwerk.putEdge(vak7, vak6, 2);
		netwerk.putEdge(vak6, vak3, 1);
		netwerk.putEdge(vak8, vak7, 4);
	}

	public static void main(String[] args)
	{
		new Applicatie();
	}
}
