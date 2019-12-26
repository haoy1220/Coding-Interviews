package 排序算法.堆排序;

/**
 * @author Hao
 * @date 2019/11/23 17:44
 */
public class Solution {
    public void heapSort(int[] arrays) {
        /*
        数组堆化
         */
        int len = arrays.length - 1;
        int beginIndex = (len - 1) >> 1;//第一个非叶子结点
        for (int i = beginIndex; i >= 0; i--) {//从第一个非叶子结点开始建堆
            maxHeapify(arrays, i, len);
        }

        /*
        堆化数据排序
         */
        for (int i = len; i > 0; i--) {
            swap(arrays, 0, i);//把最大的元素换到最后
            maxHeapify(arrays, 0, i - 1);//重新整理交换后的根结点
        }

    }

    private void maxHeapify(int[] arrays, int index, int len) {
        int left = (index << 1) + 1;
        int right = left + 1;
        int cMax = left;//默认左子结点最大
        if (left > len) return;
        if (right <= len && arrays[right] > arrays[left]) {//比较左右子节点
            cMax = right;
        }

        if (arrays[cMax] > arrays[index]) {//最大子结点与当前结点比较
            swap(arrays, cMax, index);
            maxHeapify(arrays, cMax, len);//交换后需要保持下面的结点依旧保有堆的特性
        }

    }

    private void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

}
