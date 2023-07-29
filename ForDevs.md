# Hey developers!
Want to add an ItemStack to this plugin's /give?

It's not that hard!

All you need is this:
```java
BetterSlashGive.instance.RegisterItemToGive(
  itemstack,
  new Identifier("modid", "itemname")
);
```

It's that simple. Now you can get your item with `/give @s modid:itemname`.
