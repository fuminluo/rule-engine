package org.rule.engine.utils;

import org.rule.engine.base.TreeNode;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 构建树工具
 **/
public class TreeUtils {

    /**
     * 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @return
     */
    public static <T extends TreeNode> List<T> buildTree(List<T> treeNodes, String parentId) {
        treeNodes = deepCopy(treeNodes);
        List<T> trees = new ArrayList<>();
        if (null == treeNodes) {
            return trees;
        }
        for (T treeNode : treeNodes) {
            if (treeNode.getParentId() == parentId || (parentId != null && parentId.equals(treeNode.getParentId()))) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (null != treeNode.getId() && treeNode.getId().equals(it.getParentId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }


    /**
     * 构建树
     *
     * @param treeNodes 数组
     * @param parentId  父节点
     * @param notNull   children 设置是否空数组
     * @param <T>
     * @return
     */
    public static <T extends TreeNode> List<T> buildTree(List<T> treeNodes, String parentId, boolean notNull) {
        treeNodes = deepCopy(treeNodes);
        List<T> trees = new ArrayList<>();
        if (null == treeNodes) {
            return trees;
        }
        for (T treeNode : treeNodes) {
            if (notNull && CollectionUtils.isEmpty(treeNode.getChildren())) {
                treeNode.setChildren(new ArrayList<>());
            }
            if (treeNode.getParentId() == parentId || (parentId != null && parentId.equals(treeNode.getParentId()))) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (null != treeNode.getId() && treeNode.getId().equals(it.getParentId())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }

    public static <T extends TreeNode> List<T> buildList(List<T> treeNodes) {
        List list = new ArrayList();
        buildList(treeNodes, list);
        return list;
    }


    private static <T extends TreeNode> List<T> buildList(List<T> treeNodes, List<T> list) {
        for (T treeNode : treeNodes) {
            list.add(treeNode);
            if (treeNode.getChildren() != null) {
                buildList(treeNode.getChildren(), list);
            }
        }
        return list;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, String parentId) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (parentId.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getParentId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    /**
     * 深度复制list对象,先序列化对象，再反序列化对象
     *
     * @param src 需要复制的对象列表
     * @return 返回新的对象列表
     * @throws IOException            读取Object流信息失败
     * @throws ClassNotFoundException 泛型类不存在
     */
    private static <T> List<T> deepCopy(List<T> src) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            return (List<T>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
