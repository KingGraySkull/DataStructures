package io.collections.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<T extends Comparable<T>>
{
    private Node<T> root;

    public void add(T element)
    {
        Node<T> newNode = new Node<>(element);
        if (root == null)
        {
            root = newNode;
            return;
        }
        else
        {
            Node<T> current = root;
            while (true)
            {
                Node<T> parent = current;
                if (element.compareTo(current.element) < 0)
                {
                    current = current.leftChild;
                    if (current == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else if (element.compareTo(current.element) > 0)
                {
                    current = current.rightChild;
                    if (current == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
                else
                {
                    System.out.println("Something went wrong please check your logic of inserting node");
                }
            }
        }
    }

    public void insert(T element)
    {
        this.root = insertRecursilvely(element, this.root);
    }

    private Node<T> insertRecursilvely(T element, Node<T> node)
    {
        if (node == null)
        {
            node = new Node<>(element);
            return node;
        }
        else if (element.compareTo(node.element) < 0)
        {
            node.leftChild = insertRecursilvely(element, node.leftChild);
        }
        else if (element.compareTo(node.element) > 0)
        {
            node.rightChild = insertRecursilvely(element, node.rightChild);
        }
        return node;
    }

    public void traverseLevelOrder()
    {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node<T> topNode = queue.poll();
            System.out.print(""+topNode.element);
            System.out.print(", ");
            if (topNode.hasLeftChild())
            {
                queue.add(topNode.leftChild);
            }
            if (topNode.hasRightChild())
            {
                queue.add(topNode.rightChild);
            }
        }
    }

    public void traverseInorder()
    {
        inOrder(this.root);
    }

    private void inOrder(Node<T> node)
    {
        if (node != null)
        {
            inOrder(node.leftChild);
            System.out.print(""+node.element+", ");
            inOrder(node.rightChild);
        }
    }

    public void traversePreOrder()
    {
        preOrder(this.root);
    }

    private void preOrder(Node<T> node)
    {
        if (node != null)
        {
            System.out.print(""+node.element+", ");
            inOrder(node.leftChild);
            inOrder(node.rightChild);
        }
    }

    public boolean hasKey(T element)
    {
        Node<T> current = this.root;
        if (current != null)
        {
            while (current != null)
            {
                if (element.compareTo(current.element) < 0)
                {
                    current = current.leftChild;
                }
                else if (element.compareTo(current.element) > 0)
                {
                    current = current.rightChild;
                }
                else if (element.compareTo(current.element) == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int height()
    {
        return getHeight(this.root);
    }

    private int getHeight(Node<T> node)
    {
        if (node == null)
        {
            return -1;
        }
        int leftHeight = getHeight(node.leftChild);
        int rightHeight = getHeight(node.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean remove(T element)
    {
        boolean isRemoved = false;
        Node<T> removedNode = removeHelper(this.root, element);
        isRemoved = removedNode != null ? true : false;
        return isRemoved;
    }

    private Node<T> removeHelper(Node<T> node, T element)
    {
        if (node == null)
        {
            return null;
        }
        else if (element.compareTo(node.element) < 0)
        {
            node.leftChild = removeHelper(node.leftChild, element);
        }
        else if (element.compareTo(node.element) > 0)
        {
            node.rightChild = removeHelper(node.rightChild, element);
        }
        else
        {
            System.out.println("Node to be deleted  :: "+node);
            Node<T> temp = null;
            // Case 1 :- No children
            if (node.leftChild == null && node.rightChild == null)
            {
                temp = null;
            }
            // Case 2 :- One children
            else if (node.leftChild == null)
            {
                temp = node.rightChild;
            }
            else if (node.rightChild == null)
            {
                temp = node.leftChild;
            }
            // Case 3 :- Both children are not null
            else
            {
                temp = findSuccessor(node);
            }
            System.out.println("Successor :: "+temp);
            return temp;
        }
        return node;
    }

    private Node<T> findSuccessor(Node<T> node)
    {
        Node<T> successor = null;
        if (node.hasRightChild())
        {
            Node<T> rightChild = node.rightChild;
            if (rightChild.hasLeftChild())
            {
                successor = findMin(rightChild.leftChild);
                successor.leftChild = node.leftChild;
            }
            else
            {
                successor = rightChild;
                successor.leftChild = node.leftChild;
            }
        }
        else
        {
            Node<T> leftChild = node.leftChild;
            if (leftChild.hasRightChild())
            {
                successor = findMax(leftChild.rightChild);
                successor.rightChild = node.rightChild;
            }
            else
            {
                successor = leftChild;
                successor.rightChild = node.rightChild;
            }
        }
        return successor;
    }

    private Node<T> findMin(Node<T> node)
    {
        Node<T> temp = node;
        while (temp.leftChild != null)
        {
            temp = temp.leftChild;
        }
        return temp;
    }
    private Node<T> findMax(Node<T> node)
    {
        Node<T> temp = node;
        while (temp.rightChild != null)
        {
            temp = temp.rightChild;
        }
        return temp;
    }



    private static class Node<T>
    {
        private T element;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T element)
        {
            this.element = element;
        }

        public boolean hasLeftChild()
        {
            return leftChild != null;
        }

        public boolean hasRightChild()
        {
            return rightChild != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }
}
