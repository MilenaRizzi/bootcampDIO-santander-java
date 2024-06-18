import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
  
  private List<Item> itemList;

  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<Item>();
  }


  public void adicionarItem(String nome, double preco, int quantidade) {
    itemList.add(new Item(nome, preco, quantidade));
  }

  public void removerItem(String nome) {
    List<Item> itemParaRemover = new ArrayList<Item>();
    for (Item item : itemList) {
      if (item.getNome().equalsIgnoreCase(nome)) {
        itemParaRemover.add(item);
      }
    }
    itemList.removeAll(itemParaRemover);
  }

  public double calcularValorTotal() {
    double valorTotalCarrinho = 0;
    for (Item item : itemList) {
      valorTotalCarrinho += (item.getPreco() * item.getQuantidade());
    }
    return valorTotalCarrinho;
  }

  public void exibirItens() {
    System.out.println(itemList);
  }

  public static void main(String[] args) {
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

    carrinho.adicionarItem("Escova de cabelo", 22.5, 1);
    carrinho.adicionarItem("Protetor Solar", 80, 1);

    carrinho.exibirItens();

    double valorTotal = carrinho.calcularValorTotal();
    System.out.println("o valor total é " +  valorTotal);

    carrinho.removerItem("Escova de cabelo");
    carrinho.exibirItens();

  }
}
