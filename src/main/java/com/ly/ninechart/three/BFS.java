package com.ly.ninechart.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 通过队列实现 BFS 层级遍历
 *
 * @author tuoer
 * @date 2019/9/15 21:13
 */
public class BFS {

    public static List<List<Integer>> bfs(TreeNode root) {
        if( root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList <> (  );
        Queue<TreeNode> queue = new LinkedList <> ( );
       queue.offer ( root );
        while (!queue.isEmpty ()) {
            int size = queue.size ();
            List<Integer> temp = new ArrayList <> (  );
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll ();
                temp.add ( head.value);
                if( head.left != null ) {
                  queue.offer ( head.left );
                }
                if( head.right != null ) {
                  queue.offer (head.right  );
                }
            }

            result.add ( temp );

        }

        return result;

    }

    public static void main( String[] args ) {
        System.out.println (bfs ( TreeNode.root ));
    }
}
