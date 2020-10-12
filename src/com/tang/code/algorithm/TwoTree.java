package com.tang.code.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 二叉树的遍历（前序、中序、后序、已知前中序求后序、已知中后序求前序）
 */
public class TwoTree{
    public static void main(String[] args) {

    }

    /**
     * 前序遍历，root->left->right
     * @param root
     */
    public static void preOrderTree(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println("root->"+root.val);
        preOrderTree(root.left);
        preOrderTree(root.right);
    }
     /**
     * 中序遍历，left->root->right
     * @param root
     */
    public static void midOrderTree(TreeNode root){
        if (root==null){
            return;
        }
        midOrderTree(root.left);
        System.out.println("root->"+root.val);
        midOrderTree(root.right);
    }
    /**
     * 后序遍历，left->right->root
     * @param root
     */
    public static void postOrderTree(TreeNode root){
        if (root==null){
            return;
        }
        postOrderTree(root.left);
        postOrderTree(root.right);
        System.out.println("root->"+root.val);
    }

    /**
     * 有序二叉树
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>(10);
        Stack stack=new Stack<Integer>();
        res.add(root.val);
        //左节点
        while (root.left!=null){
            stack.push(root.left.val);
        }
        while (root.right!=null){
            stack.push(root.right.val);
        }
        return res;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
}
