/*
 * This file is part of InvUI, licensed under the MIT License.
 *
 * Copyright (c) 2021 NichtStudioCode
 */

package net.momirealms.sparrow.bukkit.component;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;

public class ShadedAdventureComponentUtils {

    private static final Style FORMATTING_TEMPLATE = Style.style()
            .color(NamedTextColor.WHITE)
            .decoration(TextDecoration.ITALIC, false)
            .decoration(TextDecoration.BOLD, false)
            .decoration(TextDecoration.STRIKETHROUGH, false)
            .decoration(TextDecoration.UNDERLINED, false)
            .decoration(TextDecoration.OBFUSCATED, false)
            .build();

    public static Component withoutPreFormatting(Component component) {
        return component.style(component.style().merge(FORMATTING_TEMPLATE, Style.Merge.Strategy.IF_ABSENT_ON_TARGET));
    }
}
