DESCRIPTION = "Virtual Machine Manager"
HOMEPAGE = "http://www.virt-manager.org/"
LICENSE = "GPLv2+"

DEPENDS = "intltool virtual/gettext"
RDEPENDS_${PN} = "libvirt-python libxml2-python"
PR = "r0"

inherit autotools

LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

FILES_${PN} += "${datadir}"

SRC_URI = "http://virt-manager.org/download/sources/${PN}/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "2b622a0f4cd53f83665d9841b5a3cefa"
SRC_URI[sha256sum] = "5d2afb282fb8c4401f9e203dcb41a62746b9a909258d440d508219bc1a33803d"

SRC_URI += "file://61369d25.patch"
