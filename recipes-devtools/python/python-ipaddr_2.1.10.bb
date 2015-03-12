DESCRIPTION = "An IPv4/IPv6 manipulation library in Python."
HOMEPAGE = "http://code.google.com/p/ipaddr-py/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "ASL-LICENSE-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=3b83ef96387f14655fc854ddc3c6bd57"
PR = "r0"

SRC_URI = " http://ipaddr-py.googlecode.com/files/ipaddr-${PV}.tar.gz"
S = "${WORKDIR}/ipaddr-${PV}"

inherit distutils

SRC_URI[md5sum] = "f315ac829218e9735c5d772d59a3e0e7"
SRC_URI[sha256sum] = "d2c3bfd45147e5773108d2c8d3c65102ff234f06e2f1049a0febfa31dde4cca3"
