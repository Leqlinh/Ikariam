/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author MXP
 */
public class Munition {
    BattleField battlefield;
    Slot[] longRangeFighter, airDefence, bomber, artillery;
    
    public Munition(BattleField battlefield){
        this.battlefield = battlefield;
        this.longRangeFighter = battlefield.longRangeFighter;
        this.airDefence = battlefield.airDefence;
        this.bomber = battlefield.bomber;
        this.artillery = battlefield.artillery;
    }
    
    
    public int getMunitionOfSulfur() {
        int x = 0, y =0;
        for (Slot slot :longRangeFighter) {
            if (slot.getUnitType() == Army.Unit.Sulfur) {
                x += slot.getUnitAlive();
            }
        }
        if (x == 0) return 0;
        if (!battlefield.reserve.getSC().isEmpty()) 
            return 100-(x * 100)/((x + battlefield.reserve.getSC().size()) * 3);
        else return 0;
    }
    
    public int getMunitionOfArcher() {
        int x = 0, y =0;
        for (Slot slot :longRangeFighter) {
            if (slot.getUnitType() == Army.Unit.Archer) {
                x += slot.getUnitAlive();
            }
        }
        if (x == 0) return 0;
        if (!battlefield.reserve.getArcher().isEmpty()) 
            return 100-(x * 100)/((x + battlefield.reserve.getArcher().size()) * 3);
        else return 1;
    }
    
    public int getMunitionOfSlinger() {
        int x = 0, y =0;
        for (Slot slot :longRangeFighter) {
            if (slot.getUnitType() == Army.Unit.Slinger) {
                x += slot.getUnitAlive();
            }
        }
        if (x == 0) return 0;
        if (!battlefield.reserve.getSlinger().isEmpty()) 
            return 100-(x * 100)/((x + battlefield.reserve.getSlinger().size()) * 5);
        else return 1;
    }
    
    public int getMunitionOfGyrocopter() {
        int x = 0, y =0;
        for (Slot slot :airDefence) {
            if (slot.getUnitType() == Army.Unit.Gyrocopter) {
                x += slot.getUnitAlive();
            }
        }
        if (x == 0) return 0;
        if (!battlefield.reserve.getGyrocopter().isEmpty()) 
            return 100-(x * 100)/((x + battlefield.reserve.getGyrocopter().size()) * 4);
        else return 1;
    }
    
    public int getMunitionOfBB() {
        int x = 0, y =0;
        for (Slot slot :bomber ) {
            if (slot.getUnitType() == Army.Unit.Balloon) {
                x += slot.getUnitAlive();
            }
        }
        if (x == 0) return 0;
        if (!battlefield.reserve.getBB().isEmpty()) 
            return 100-(x * 100)/((x + battlefield.reserve.getBB().size()) * 2);
        else return 1;
    }
    
    public int getMunitionOfMortar() {
        int x = 0, y =0;
        for (Slot slot : artillery ) {
            if (slot.getUnitType() == Army.Unit.Mortar) {
                x += slot.getUnitAlive();
            }
        }
        if (x == 0) return 0;
        if (!battlefield.reserve.getMortar().isEmpty()) 
            return 100-(x * 100)/((x + battlefield.reserve.getMortar().size()) * 3);
        else return 1;
    }
    
    public int getMunitionOfCatapult() {
        int x = 0, y =0;
        for (Slot slot :bomber ) {
            if (slot.getUnitType() == Army.Unit.Catapult) {
                x += slot.getUnitAlive();
            }
        }
        if (x == 0) return 0;
        if (!battlefield.reserve.getCatapult().isEmpty()) 
            return 100-(x * 100)/((x + battlefield.reserve.getCatapult().size()) * 5);
        else return 1;
    }
    
    public void setMunition() {
        for (Army.ClassUnit classUnit : Army.ClassUnit.values()) {
            for (Slot slot : battlefield.getMyClassUnit(classUnit)) {
                int x = 0;
                    if (slot.getUnitType() == Army.Unit.Sulfur){
                        slot.setTotalMunition(getMunitionOfSulfur());
                    }
                    if (slot.getUnitType() == Army.Unit.Archer){
                        slot.setTotalMunition(getMunitionOfArcher());
                    }
                    if (slot.getUnitType() == Army.Unit.Slinger){
                        slot.setTotalMunition(getMunitionOfSlinger());
                    }
                    if (slot.getUnitType() == Army.Unit.Gyrocopter){
                        slot.setTotalMunition(getMunitionOfGyrocopter());
                    }
                    if (slot.getUnitType() == Army.Unit.Balloon){
                        slot.setTotalMunition(getMunitionOfBB());
                    }
                    if (slot.getUnitType() == Army.Unit.Mortar){
                        slot.setTotalMunition(getMunitionOfMortar());
                    }
                    if (slot.getUnitType() == Army.Unit.Catapult){
                        slot.setTotalMunition(getMunitionOfCatapult());
                    }
            }
        }
    }
    
}
