package me.ufo.collectors.util;


import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class Style {

  public static final String CHARACTERS = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";
  public static final char SECTION_CHAR = '\u00A7';
  public static final char AMPERSAND_CHAR = '&';

  private Style() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  public static String translate(final String in) {
    return _translate(in);
  }

  public static List<String> translate(final List<String> in) {
    final int size = in.size();
    final List<String> out = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      out.add(_translate(in.get(i)));
    }
    return out;
  }

  public static String[] translate(final String[] in) {
    final int size = in.length;
    final String[] out = new String[size];
    for (int i = 0; i < size; i++) {
      out[i] = _translate(in[i]);
    }
    return out;
  }

  private static String _translate(final String textToTranslate) {
    final char[] b = textToTranslate.toCharArray();
    final int length = b.length;
    for (int i = 0; i < length - 1; i++) {
      if (b[i] == AMPERSAND_CHAR && CHARACTERS.indexOf(b[i + 1]) > -1) {
        b[i] = SECTION_CHAR;
        b[i + 1] = Character.toLowerCase(b[i + 1]);
      }
    }
    return new String(b);
  }

  public static boolean message(final CommandSender sender, final String in) {
    if (sender != null) {
      sender.sendMessage(ChatColor.translateAlternateColorCodes('&', in));
      return true;
    }
    return false;
  }

  public static boolean message(final CommandSender sender, final String... in) {
    if (sender != null) {
      sender.sendMessage(translate(in));
      return true;
    }
    return false;
  }

}
