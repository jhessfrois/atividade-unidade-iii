class TreeNode {
  String categoria;
  TreeNode left, right;

  TreeNode(String categoria) {
    this.categoria = categoria;
    this.left = null;
    this.right = null;
  }
}

public class ativi_02 {

  // Verifica se a árvore é uma BST usando limites de String
  public static boolean isBST(TreeNode node, String min, String max) {
    if (node == null) return true;

    // Verifica se a categoria está dentro dos limites
    if ((min != null && node.categoria.compareTo(min) <= 0) ||
      (max != null && node.categoria.compareTo(max) >= 0)) {
      return false;
    }

    // Recursivamente verifica as subárvores esquerda e direita
    return isBST(node.left, min, node.categoria) &&
         isBST(node.right, node.categoria, max);
  }

  // Exemplo de uso
  public static void main(String[] args) {
    // Validação de BST
    TreeNode root = new TreeNode("Eletrônicos");
    root.left = new TreeNode("Celulares");
    root.right = new TreeNode("Informática");
    root.left.left = new TreeNode("Acessórios");
    root.right.right = new TreeNode("Notebooks");

    boolean bst = isBST(root, null, null);
    System.out.println("A árvore é BST? " + bst);
  }
}