package com.imooc.gradle.todo;

/**
 * Create by zhudapeng
 * 2019-08-25 21:23
 */
public class TodoItem {
    // 代办事项名称
    private String name;
    // 已完成
    private boolean hasDone;

    public TodoItem(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public boolean isHasDone() {
        return this.hasDone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHasDone(boolean hasDone) {
        this.hasDone = hasDone;
    }
    public String toString() {
        return this.name + (this.hasDone ? " has done!" : " not have done!");
    }
}
