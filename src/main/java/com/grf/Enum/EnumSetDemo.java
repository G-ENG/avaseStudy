package com.grf.Enum;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class EnumSetDemo {
    enum DoorRoom {
        ROOM1, ROOM2, ROOM3, ROOM4
    }

    private static EnumSet<DoorRoom> OpenDoorRooms = EnumSet.noneOf(DoorRoom.class);

    private static void openRoom(DoorRoom aRoom) {
        OpenDoorRooms.add(aRoom);
    }

    private static void openSomeRoom(EnumSet<DoorRoom> someRoom) {
        OpenDoorRooms.addAll(someRoom);
    }

    private static void closeRoom(DoorRoom aRoom) {
        OpenDoorRooms.remove(aRoom);
    }

    private static void closeSomeRoom(EnumSet<DoorRoom> someRoom) {
        OpenDoorRooms.removeAll(someRoom);
    }

    private static boolean isRoomOpen(DoorRoom aRoom) {
        return OpenDoorRooms.contains(aRoom);
    }

    //使用enumSet好处在于，对多个房间判断 不用写很多if语句，代码可读性高
    static boolean isSomeRoomOpen(EnumSet<DoorRoom> someRoom) {
        return OpenDoorRooms.containsAll(someRoom);
    }

    private static void listOpenRoom() {
        if (OpenDoorRooms.isEmpty()) {
            System.out.println("木得");
        } else {
            for (DoorRoom openDoorRoom : OpenDoorRooms) {
                System.out.println(openDoorRoom.name());
            }
        }
    }

    @Test
    public void TestEnumRoom() {
        System.out.println("所有开启门的房间:");
        listOpenRoom();

        openRoom(DoorRoom.ROOM1);
        System.out.println("打开房间1的门");
        System.out.println("房间1的门是否开启：" + isRoomOpen(DoorRoom.ROOM1));
        System.out.println("房间2的门是否开启" + isRoomOpen(DoorRoom.ROOM2));

        System.out.println("接着打开房间2、3、4");
        openSomeRoom(EnumSet.of(DoorRoom.ROOM2, DoorRoom.ROOM3, DoorRoom.ROOM4));
        System.out.println("所有开启门的房间");
        listOpenRoom();

        closeRoom(DoorRoom.ROOM1);
        closeSomeRoom(EnumSet.of(DoorRoom.ROOM2, DoorRoom.ROOM3, DoorRoom.ROOM4));
        openRoom(DoorRoom.ROOM2);
        System.out.println("房间2的门是否开启" + isRoomOpen(DoorRoom.ROOM2));
    }
}
