package com.reasure.tieredtools.util;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.reasure.tieredtools.TieredToolMod;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("LoggingSimilarMessage")
public class ItemUtil {
    public static void modifyBaseAttribute(SwordItem item, float attackDamage, double attackSpeed) {
        item.attackDamage = attackDamage;
        Multimap<Attribute, AttributeModifier> mutableAttributeMap = LinkedHashMultimap.create(item.defaultModifiers);
        modifyAttribute(mutableAttributeMap, Attributes.ATTACK_DAMAGE, Item.BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", attackDamage);
        modifyAttribute(mutableAttributeMap, Attributes.ATTACK_SPEED, Item.BASE_ATTACK_SPEED_UUID, "Weapon modifier", attackSpeed);
        item.defaultModifiers = ImmutableMultimap.copyOf(mutableAttributeMap);
        TieredToolMod.getLogger().info("{} modified: {} attack damage, {} attack speed", item, attackDamage + 1.0f, attackSpeed + 4.0);
    }

    public static void modifyBaseAttribute(DiggerItem item, float attackDamage, double attackSpeed) {
        item.attackDamageBaseline = attackDamage;
        Multimap<Attribute, AttributeModifier> mutableAttributeMap = LinkedHashMultimap.create(item.defaultModifiers);
        modifyAttribute(mutableAttributeMap, Attributes.ATTACK_DAMAGE, Item.BASE_ATTACK_DAMAGE_UUID, "Tool modifier", attackDamage);
        modifyAttribute(mutableAttributeMap, Attributes.ATTACK_SPEED, Item.BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeed);
        item.defaultModifiers = ImmutableMultimap.copyOf(mutableAttributeMap);
        TieredToolMod.getLogger().info("{} modified: {} attack damage, {} attack speed", item, attackDamage + 1.0f, attackSpeed + 4.0);
    }

    public static void modifyBaseAttribute(ArmorItem item, int defense, float toughness) {
        item.defense = defense;
        item.toughness = toughness;
        UUID uuid = ArmorItem.ARMOR_MODIFIER_UUID_PER_TYPE.get(item.type);
        Multimap<Attribute, AttributeModifier> mutableAttributeMap = LinkedHashMultimap.create(item.defaultModifiers);
        modifyAttribute(mutableAttributeMap, Attributes.ARMOR, uuid, "Armor modifier", defense);
        modifyAttribute(mutableAttributeMap, Attributes.ARMOR_TOUGHNESS, uuid, "Armor toughness", toughness);
        item.defaultModifiers = ImmutableMultimap.copyOf(mutableAttributeMap);
        TieredToolMod.getLogger().info("{} modified: {} defense, {} armor toughness", item, defense, toughness);
    }

    private static void modifyAttribute(Multimap<Attribute, AttributeModifier> attributeMap, Attribute attribute, UUID uuid, String name, double amount) {
        removeAttribute(attributeMap, attribute, uuid);
        addAttribute(attributeMap, attribute, uuid, name, amount);
    }

    private static void removeAttribute(Multimap<Attribute, AttributeModifier> attributeMap, Attribute attribute, UUID uuid) {
        attributeMap.get(attribute).stream()
                .filter(Objects::nonNull)
                .filter(modifier -> modifier.getId().equals(uuid))
                .findFirst()
                .ifPresent(modifier -> attributeMap.remove(attribute, modifier));
    }

    private static void addAttribute(Multimap<Attribute, AttributeModifier> attributeMap, Attribute attribute, UUID uuid, String name, double amount) {
        attributeMap.put(attribute, new AttributeModifier(uuid, name, amount, AttributeModifier.Operation.ADDITION));
    }
}
