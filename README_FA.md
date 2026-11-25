# XrayLite — Fabric 1.21.4

ماد کلاینتی و سبک X-Ray برای Minecraft 1.21.4 و Fabric.

## امکانات
- کلید پیش‌فرض `X` برای روشن/خاموش کردن.
- نمایش سنگ‌های معدنی و Ancient Debris.
- بدون تنظیمات سنگین و بدون وابستگی به سرور.
- پیام وضعیت هنگام تغییر حالت.
- قابل تغییر بودن کلید از Options → Controls → Key Binds.

## ساخت فایل JAR
نیازمندی‌ها: Java 21 و Gradle 8.12

```bash
gradle build
```

فایل خروجی:
`build/libs/xraylite-1.0.0.jar`

## ساخت با GitHub Actions
1. کل پوشه پروژه را در یک GitHub repository آپلود کن.
2. از تب Actions، ورک‌فلو `Build XrayLite` را اجرا کن.
3. از بخش Artifacts فایل `XrayLite-Fabric-1.21.4` را دانلود کن.

## نصب
فایل JAR را داخل پوشه `mods` قرار بده. نصب Fabric Loader و Fabric API برای Minecraft 1.21.4 لازم است.

## نکته
این ماد فقط سمت کلاینت است. در سرورهای چندنفره ممکن است استفاده از X-Ray خلاف قوانین سرور باشد؛ فقط در دنیاهای شخصی یا سرورهایی که اجازه می‌دهند استفاده کن.
