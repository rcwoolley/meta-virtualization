DESCRIPTION = "Native Go bindings for D-Bus"
HOMEPAGE = "https://github.com/godbus/dbus"
SECTION = "devel/go"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b5ac622301483800715d770434e27e5b"

PR = "r0"
SRCNAME = "dbus"

PKG_NAME = "github.com/godbus/${SRCNAME}"
SRC_URI = "git://${PKG_NAME}.git"

SRCREV = "cb98efbb933d8389ab549a060e880ea3c375d213"
PV = "1+git${SRCREV}"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${prefix}/local/go/src/${PKG_NAME}
	cp -r ${S}/* ${D}${prefix}/local/go/src/${PKG_NAME}/
}

SYSROOT_PREPROCESS_FUNCS += "go_dbus_sysroot_preprocess"

go_dbus_sysroot_preprocess () {
    install -d ${SYSROOT_DESTDIR}${prefix}/local/go/src/${PKG_NAME}
    cp -r ${D}${prefix}/local/go/src/${PKG_NAME} ${SYSROOT_DESTDIR}${prefix}/local/go/src/$(dirname ${PKG_NAME})
}

FILES_${PN} += "${prefix}/local/go/src/${PKG_NAME}/*"
