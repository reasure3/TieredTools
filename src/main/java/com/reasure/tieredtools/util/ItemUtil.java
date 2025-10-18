package com.reasure.tieredtools.util;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;

import java.util.Objects;
import java.util.UUID;

public class ItemUtil {
    public static void modifyBaseAttribute(DiggerItem item, float attackDamage, double attackSpeed) {
        item.attackDamageBaseline = attackDamage;
        Multimap<Attribute, AttributeModifier> mutableAttributeMap = ArrayListMultimap.create(item.defaultModifiers);
        modifyAttribute(mutableAttributeMap, Attributes.ATTACK_DAMAGE, Item.BASE_ATTACK_DAMAGE_UUID, attackDamage);
        modifyAttribute(mutableAttributeMap, Attributes.ATTACK_SPEED, Item.BASE_ATTACK_SPEED_UUID, attackSpeed);
        item.defaultModifiers = ImmutableMultimap.copyOf(mutableAttributeMap);
    }

    private static void modifyAttribute(Multimap<Attribute, AttributeModifier> attributeMap, Attribute attribute, UUID uuid, double amount) {
        removeAttribute(attributeMap, attribute, uuid);
        addAttribute(attributeMap, attribute, uuid, amount);
    }

    private static void removeAttribute(Multimap<Attribute, AttributeModifier> attributeMap, Attribute attribute, UUID uuid) {
        attributeMap.get(attribute).stream()
                .filter(Objects::nonNull).filter(modifier -> modifier.getId().equals(uuid))
                .findFirst()
                .ifPresent(modifier -> attributeMap.remove(attribute, modifier));
    }

    private static void addAttribute(Multimap<Attribute, AttributeModifier> attributeMap, Attribute attribute, UUID uuid, double amount) {
        attributeMap.put(attribute, new AttributeModifier(uuid, "Tool modifier", amount, AttributeModifier.Operation.ADDITION));
    }
}
