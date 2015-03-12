DESCRIPTION = "A graphical console client for connecting to libvirt virtual machines"
HOMEPAGE = "http://www.virt-manager.org/"
LICENSE = "GPLv2+"

DEPENDS = "gdk-pixbuf glib-2.0 spice gtk-vnc libxml2"
RDEPENDS_${PN} = "spice gtk-vnc gtk-vnc-python"
PR = "r0"

inherit autotools pkgconfig

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
FILES_${PN} += "${datadir}"

SRC_URI = "http://virt-manager.org/download/sources/${PN}/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "c0d6d2de66e61df6c2ad339625c58a2a"
SRC_URI[sha256sum] = "4af5e660b3d15bcd3727851af1ddc2f08805c50ad4fc30714e21b20113fe9a83"
