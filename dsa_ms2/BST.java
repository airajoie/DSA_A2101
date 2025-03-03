/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa_ms2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aira Joie Piopongco
 */
public class BST {

    private class Node {

        Stocks stock;
        Node left, right;

        Node(Stocks stock) {
            this.stock = stock;
            left = right = null;
        
       }
    }
    
    private Node root;

    public BST() {
        root = null;
    }

    public boolean insert(Stocks stock) {
        if (isEngineNumberUnique(stock.getEngineNumber())) {
            root = insertRec(root, stock);
            return true;
        } else {
            return false; 
        }
    }

    private Node insertRec(Node root, Stocks stock) {
        if (root == null) {
            return new Node(stock);
        }
        if (stock.getEngineNumber().compareTo(root.stock.getEngineNumber()) < 0) {
            root.left = insertRec(root.left, stock);
        } else if (stock.getEngineNumber().compareTo(root.stock.getEngineNumber()) > 0) {
            root.right = insertRec(root.right, stock);
        } else {
            return root; 
        }

        return root;
    }

    public boolean isEngineNumberUnique(String engineNumber) {
        return searchRec(root, engineNumber) == null;
    }

    public Stocks search(String engineNumber) {
        return searchRec(root, engineNumber);
    }

    private Stocks searchRec(Node root, String engineNumber) {
        if (root == null || root.stock.getEngineNumber().equals(engineNumber)) {
            return root != null ? root.stock : null;
        }
        if (engineNumber.compareTo(root.stock.getEngineNumber()) < 0) {
            return searchRec(root.left, engineNumber);
        }

        return searchRec(root.right, engineNumber);
    }

    public void delete(String engineNumber) {
        root = deleteRec(root, engineNumber);
    }

    private Node deleteRec(Node root, String engineNumber) {
        if (root == null) {
            return root;
        }
        if (engineNumber.compareTo(root.stock.getEngineNumber()) < 0) {
            root.left = deleteRec(root.left, engineNumber);
        } else if (engineNumber.compareTo(root.stock.getEngineNumber()) > 0) {
            root.right = deleteRec(root.right, engineNumber);
        } else {
            if (root.stock.getStatus().equals("Sold")) {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                root.stock = minValue(root.right);
                root.right = deleteRec(root.right, root.stock.getEngineNumber());
            }
        }
        return root;
    }

    private Stocks minValue(Node root) {
        Stocks minv = root.stock;
        while (root.left != null) {
            minv = root.left.stock;
            root = root.left;
        }
        return minv;
    }

    public List<Stocks> inOrder() {
        List<Stocks> stocksList = new ArrayList<>();
        inOrderRec(root, stocksList);
        return stocksList;
    }

    private void inOrderRec(Node root, List<Stocks> stocksList) {
        if (root != null) {
            inOrderRec(root.left, stocksList);
            stocksList.add(root.stock);
            inOrderRec(root.right, stocksList);
        }
    }

    public void mergeSort(List<Stocks> stocksList) {
        if (stocksList.size() > 1) {
            int mid = stocksList.size() / 2;
            List<Stocks> left = new ArrayList<>(stocksList.subList(0, mid));
            List<Stocks> right = new ArrayList<>(stocksList.subList(mid, stocksList.size()));

            mergeSort(left);
            mergeSort(right);

            merge(stocksList, left, right);
        }
    }

    private void merge(List<Stocks> stocksList, List<Stocks> left, List<Stocks> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getBrand().compareTo(right.get(j).getBrand()) <= 0) {
                stocksList.set(k++, left.get(i++));
            } else {
                stocksList.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            stocksList.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            stocksList.set(k++, right.get(j++));
        }
    }
}
    

