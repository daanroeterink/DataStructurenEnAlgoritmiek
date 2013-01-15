import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tom Kostense, Daan Roeterink
 * 
 * @param <V>
 * @param <E>
 */
public class PERTNetwerk<V extends PertVertex, E extends Number> extends nl.saxion.act.graphs.WGT_DiGraph<V, E>
{

	/**
	 * All the added vertices
	 */
	private List<V> vertices = new ArrayList<V>();

	/**
	 * All the vertices in a topological order
	 */
	private List<V> TopoList = new ArrayList<V>();

	/**
	 * @return list of vertices
	 */
	public List<V> getVertices()
	{
		return vertices;
	}

	/**
	 * Vertices list in Topological order
	 * 
	 * @return list of vertices
	 */
	public List<V> getTopoList()
	{
		return TopoList;
	}

	/*
	 * puts the vertex in the graph and it adds it to our vertices list
	 */
	@Override
	public void putVertex(V vertex)
	{
		super.putVertex(vertex);
		vertices.add(vertex);
	}

	/**
	 * Calculates the start time for all Vertices in the topological list
	 */
	public void getStartTime()
	{
		for (V v : TopoList)
		{
			int order = TopoList.indexOf(v);
			if (order == 0)
			{
				v.setMinPathValue(0);
			}
			else
			{
				for (V vak : TopoList)
				{
					int order2 = TopoList.indexOf(vak);
					if (order2 < order)
					{
						if (hasEdge(vak, v))
						{
							if (v.getMinPathValue() < ((Integer) edge(vak, v)) + vak.getMinPathValue())
							{
								v.setMinPathValue(((Integer) edge(vak, v)) + vak.getMinPathValue());
							}
						}
					}
					else
					{
						break;
					}
				}
			}
		}
	}

	/**
	 * Calculates the last start time for all Vertices in the topological list
	 */
	public void getLastStartTime()
	{
		Collections.reverse(TopoList);

		for (V v : TopoList)
		{
			int order = TopoList.indexOf(v);
			if (order == 0)
			{
				v.setMaxPathValue(v.getMinPathValue());
			}
			for (V vak : TopoList)
			{
				if (hasEdge(vak, v))
				{
					int maxValue = v.getMaxPathValue() - (Integer) edge(vak, v);
					if (vak.getMaxPathValue() < 0 || maxValue < vak.getMaxPathValue())
						vak.setMaxPathValue(maxValue);
				}
			}
		}
		Collections.reverse(TopoList);
	}

	/**
	 * creates an Topological list of the list of vertices
	 */
	public void createTopologicalList()
	{
		while (vertices.size() > 0)
		{
			Iterator<V> i = vertices.iterator();
			while (i.hasNext())
			{
				V v = i.next();
				boolean hasedge = false;
				for (V vak : vertices)
				{
					if (vak != v)
					{
						if (hasEdge(vak, v))
						{
							hasedge = true;
							break;
						}
					}
				}
				if (!hasedge)
				{
					TopoList.add(v);
					i.remove();
				}
			}
		}
	}
}
