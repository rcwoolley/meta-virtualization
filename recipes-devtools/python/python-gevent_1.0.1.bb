HOMEPAGE = "http://www.gevent.org"
SUMMARY = "A coroutine-based Python networking library"
DESCRIPTION = "\
  gevent is a coroutine-based Python networking library that uses greenlet \
  to provide a high-level synchronous API on top of the libevent event \
  loop. \
  " 
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2dbb33d00e1fd31c7041460a81ac0bd2"
DEPENDS += "python-greenlet libevent"
RDEPENDS_${PN} += "python-greenlet python-mime python-pprint python-re"

SRCNAME = "gevent"

SRC_URI = "http://pypi.python.org/packages/source/g/gevent/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "7b952591d1a0174d6eb6ac47bd975ab6"
SRC_URI[sha256sum] = "4627e215d058f71d95e6b26d9e7be4c263788a4756bd2858a93775f6c072df43"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://libev-conf.patch"
