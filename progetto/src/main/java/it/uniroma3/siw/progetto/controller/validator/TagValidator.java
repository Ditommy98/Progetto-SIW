package it.uniroma3.siw.progetto.controller.validator;

import javax.servlet.http.HttpServletRequest;

/* Classe che valida che i dati di un tag inseriti da un utente siano validi */
public class TagValidator 
{
	public boolean validate(HttpServletRequest request)
	{
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String colore = request.getParameter("colore");
		boolean datiValidi = true;
				
		/* Il nome è un campo obbligatorio */
		if(nome==null || nome.isEmpty())
		{
			datiValidi = false;
			request.setAttribute("erroreNome", "Campo Obbligatorio");
		}
		
		/* La descrizione può contenere massimo 200 caratteri */
		if(descrizione.length() > 200)
		{
			datiValidi = false;
			request.setAttribute("erroreDescrizione", "Max 200 caratteri");
		}
		
		/* Il colore non può essere nullo */
		if(colore==null || colore.isEmpty())
		{
			datiValidi = false;
			request.setAttribute("erroreColore", "Il colore è obbligatorio");
		}
		
		return datiValidi;
	}
}
