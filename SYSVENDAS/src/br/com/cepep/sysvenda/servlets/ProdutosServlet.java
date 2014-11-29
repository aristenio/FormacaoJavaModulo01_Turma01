package br.com.cepep.sysvenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cepep.sysvenda.dao.ProdutoDao;
import br.com.cepep.sysvenda.entidades.Produto;

/**
 * Servlet implementation class ProdutosServlet
 */
public class ProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ProdutoDao produtoDao;
    
	@Override
	public void init() throws ServletException {
		produtoDao = new ProdutoDao();
	}
	
	@Override
	public void destroy() {
		produtoDao.destroy();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Lista de produtos</title>");
		out.println("</head>");
		out.println("<body>");
		
		try {
			List<Produto> listaProdutos = produtoDao.listarProdutos();
			
			for (Produto produto : listaProdutos) {
				out.print("Produto </br>");
				out.print(" Nome:"+produto.getNome());
				out.print(" Descrição:"+produto.getDescricaoGrande());
				out.print(" Preço:"+produto.getPreco());
				out.print("</br>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("</body>");
		out.println("</html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = new Produto();
		
		produto.setNome(request.getParameter("nome"));
		produto.setDescricaoGrande(request.getParameter("descricao"));
		produto.setDescricaoPequena(request.getParameter("descricaoReduzida"));
		produto.setPreco(Double.valueOf(request.getParameter("preco")));
		produto.setPrecoDesconto(Double.valueOf(request.getParameter("precoDesconto")));
		produto.setDesconto(Float.valueOf(request.getParameter("desconto")));
		produto.setImagem(request.getParameter("imagem"));
		
		try {
			produtoDao.inserir(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cadastro de produtos</title>");
		out.println("</head>");
		out.println("<body>");
		out.print("Produto inserido com sucesso.");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
