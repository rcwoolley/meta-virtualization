DESCRIPTION = "A graphical console client for connecting to libvirt virtual machines"
HOMEPAGE = "http://www.virt-manager.org/"
LICENSE = "GPLv2+"

DEPENDS = "intltool virtual/gettext gdk-pixbuf glib-2.0 spice gtk-vnc libxml2 gtk+ gtk+3 libvirt spice-gtk"
# libgovirt
PR = "r0"

inherit autotools pkgconfig mime

EXTRA_OECONF += "--disable-update-mimedb"

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
FILES_${PN} += "${datadir}"

SRC_URI = "http://virt-manager.org/download/sources/${PN}/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "4b1e9a2029e0dfff741e17bb915f75ec"
SRC_URI[sha256sum] = "e9c583bcb5acdabac6a8a13eff6ce4e093a3050645771628f832e15ce685d437"
