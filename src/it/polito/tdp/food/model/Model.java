package it.polito.tdp.food.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.food.db.Condiment;
import it.polito.tdp.food.db.FoodDao;


public class Model {
	
	
	FoodDao dao = new FoodDao();
	private Graph<Condiment, DefaultWeightedEdge> grafo;
	private List<Condiment> ingredienti;
	
	

	public void creaGrafo(double calorie) {
			// creare oggetto grafo
			this.grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
			
			//aggiungo i vertici
			Graphs.addAllVertices(this.grafo, this.getIngredientiCalorie(calorie));
			
			// aggiungo archi e pesi
			Graphs.addEdgeWithVertices(grafo, partenza, arrivo, peso);
		
		
	}
	
	public Set<Condiment> getIngredientiCalorie(double calorie){
		this.ingredienti = dao.listAllCondiment();
		Set<Condiment> setIngredientiCalorie = new HashSet<Condiment>();
		for(Condiment c :ingredienti) {
			if(!setIngredientiCalorie.contains(c)) {
				if(c.getCondiment_calories()<calorie) {
					setIngredientiCalorie.add(c);
				}		
			}
		}
		return setIngredientiCalorie;
	}
}
